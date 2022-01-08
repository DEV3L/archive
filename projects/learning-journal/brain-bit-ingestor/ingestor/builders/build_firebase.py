import pyrebase

from ingestor.utils.env import env
from ingestor.utils.logging_service import LoggingService

logger = LoggingService('Firebase').logger

FIREBASE_API_KEY = env('FIREBASE_API_KEY')
FIREBASE_AUTH_DOMAIN = env('FIREBASE_AUTH_DOMAIN')
FIREBASE_DATABASE_URL = env('FIREBASE_DATABASE_URL')
FIREBASE_STORAGE_BUCKET = env('FIREBASE_STORAGE_BUCKET')

config = {
    "apiKey": FIREBASE_API_KEY,
    "authDomain": FIREBASE_AUTH_DOMAIN,
    "databaseURL": FIREBASE_DATABASE_URL,
    "storageBucket": FIREBASE_STORAGE_BUCKET
}

_firebase = None
_auth = None
_db = None


def _get_firebase_instance():
    global _firebase
    global _auth
    global _db

    if _firebase:
        return _firebase, _auth, _db

    logger.info("Initialized Firebase")

    _firebase = pyrebase.initialize_app(config)
    _auth = _firebase.auth()
    _db = _firebase.database()

    return _firebase, _auth, _db


def get_firebase_auth_and_db():
    _, auth, db = _get_firebase_instance()
    return auth, db
