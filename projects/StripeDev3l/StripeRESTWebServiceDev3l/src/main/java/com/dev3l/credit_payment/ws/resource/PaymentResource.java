package com.dev3l.credit_payment.ws.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dev3l.credit_payment.ws.ResourceConstants;
import com.dev3l.credit_payment.ws.agent.StripeAgent;
import com.dev3l.credit_payment.ws.bean.StripeBean;
import com.stripe.model.Charge;

@Path(ResourceConstants.ROOT_PATH_PAYMENT)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentResource {
	private StripeAgent stripeAgent;

	@Deprecated
	public PaymentResource() {
	}

	@Inject
	public PaymentResource(final StripeAgent stripeAgent) {
		this.stripeAgent = stripeAgent;
	}

	@POST
	@Path(ResourceConstants.PAYMENT_PATH_CHARGE)
	@Consumes(MediaType.APPLICATION_JSON)
	// curl -X POST http://localhost:8080/CreditPaymentsDev3l/payment/charge -H "Content-Type: application/json" -d '{"number":"4242424242424242","expMonth":"01","expYear":"2018","cvc":"123","name":"Test Dev3l","currency":"usd","amount":"100"}'
	public Response add(final StripeBean stripeBean) {
		//TODO validation checks here before calling add
		Charge charge = stripeAgent.charge(stripeBean);
		
		if(charge == null) {
			return Response.status(500).build();
		}
		
		return Response.ok().entity(new GenericEntity<Charge>(charge) {}).build();
	}
}
