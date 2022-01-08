from ingestor.builders.build_firebase import get_firebase_auth_and_db
from ingestor.utils.env import env

USER = env('FIREBASE_AUTH_USER')
PASSWORD = env('FIREBASE_AUTH_PASSWORD')


def build_firebase_connection_for_tests():
    auth, db = get_firebase_auth_and_db()

    user = auth.sign_in_with_email_and_password(USER, PASSWORD)
    id_token = user['idToken']

    return db, id_token
