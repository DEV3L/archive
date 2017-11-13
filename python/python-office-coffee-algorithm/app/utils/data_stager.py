from app.coffee_pot import CoffeePot
from app.employee import Employee


def stage_employees(*, count=1):
    employees = []
    for i in range(count):
        employees.append(_create_employee())
    return employees


def stage_coffee_pots(*, count=1):
    coffee_pots = []
    for i in range(count):
        coffee_pots.append(_create_employee())
    return coffee_pots


def _create_employee():
    return Employee()


def _create_coffee_pot():
    return CoffeePot()
