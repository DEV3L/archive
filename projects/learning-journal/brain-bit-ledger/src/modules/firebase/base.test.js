describe('Base', () => {
  afterEach(() => {
    jest.resetModules();
  });

  test('firebase initializeApp not called if already initialized', () => {
    const firebase = require('firebase');
    jest.mock('firebase');

    firebase.initializeApp = config => {
      throw 'Should not be hit in test';
    };
    firebase.apps = [1];

    let mockAuth = jest.fn();
    let authReturnValue = 'auth';
    mockAuth.mockReturnValueOnce(authReturnValue);
    firebase.auth = mockAuth;

    let auth = require('./base');

    expect(mockAuth.mock.calls.length).toBe(1);
    expect(auth).toEqual({ auth: authReturnValue });
  });

  test('firebase initializeApp called with firebase environment variables', () => {
    const firebase = require('firebase');
    jest.mock('firebase');

    const env = process.env;
    process.env = {
      REACT_APP_FIREBASE_KEY: 'key',
      REACT_APP_FIREBASE_DOMAIN: 'domain',
      REACT_APP_FIREBASE_DATABASE: 'database',
      REACT_APP_FIREBASE_PROJECT_ID: 'project',
      REACT_APP_FIREBASE_STORAGE_BUCKET: 'bucket',
      REACT_APP_FIREBASE_SENDER_ID: 'sender',
      REACT_APP_EXTRA_KEY: 'extra',
    };

    const expectedConfig = {
      apiKey: 'key',
      authDomain: 'domain',
      databaseURL: 'database',
      projectId: 'project',
      storageBucket: 'bucket',
      messagingSenderId: 'sender',
    };

    let mockInitializeApp = jest.fn();
    firebase.initializeApp = mockInitializeApp;
    firebase.apps = [];

    require('./base');
    expect(mockInitializeApp.mock.calls[0][0]).toEqual(expectedConfig);

    process.env = env;
  });
});
