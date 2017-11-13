from setuptools import setup, find_packages

version = '0.1'

setup(
    name='wisdom-chatbot',
    packages=find_packages(),
    # TODO apply versioning from my other github projects
    version=version,
    description='A bot that broadcasts a prophetic message to a HipChat room once a day.',
    author='Justin Beall',
    author_email='jus.beall@gmail.com',
    url='https://github.com/DEV3L/wisdom-chatbot',
    download_url='https://github.com/DEV3L/wisdom-chatbot/tarball/{version}'.format(version=version),
    keywords=['dev3l', 'wisdom-chatbot', 'hipchat', 's3', 'python'],  # arbitrary keywords
    install_requires=[
        # TODO read requirements.txt and list items here
        'bandit==1.4.0',
        'boto==2.48.0',
        'coverage==4.4.1',
        'pylint==1.7.2',
        'pytest==3.1.3',
    ],
    classifiers=[
        'Environment :: Console',
        'Intended Audience :: Developers',
        'License :: OSI Approved :: MIT License',
        'Operating System :: OS Independent',
        'Programming Language :: Python',
        'Programming Language :: Python :: 3',
        'Programming Language :: Python :: 3.6',
        'Topic :: Software Development :: Libraries :: Python Modules'],
)
