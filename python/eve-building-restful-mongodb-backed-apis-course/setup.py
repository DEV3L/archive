from setuptools import find_packages, setup

setup(
    name='eve-building-restful-mongodb-backed-apis-course',
    packages=find_packages(),
    version='0.1',
    description='Repository for Talk Python Training Course - Eve: Building RESTful APIs with MongoDB and Flask.',
    author='Justin Beall',
    author_email='jus.beall@gmail.com',
    url='https://github.com/DEV3L/eve-building-restful-mongodb-backed-apis-course',
    download_url='https://github.com/DEV3L/eve-building-restful-mongodb-backed-apis-course/tarball/0.1',
    keywords=['dev3l', 'eve', 'talkpython', 'rest'],
    install_requires=[
        'eve'
    ],
    classifiers=[
        'Environment :: Console',
        'Intended Audience :: Developers',
        'License :: OSI Approved :: THE BEER-WARE LICENSE',
        'Operating System :: OS Independent',
        'Programming Language :: Python',
        'Programming Language :: Python :: 3',
        'Programming Language :: Python :: 3.6',
        'Topic :: Software Development :: Libraries :: Python Modules'],
)
