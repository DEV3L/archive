from setuptools import setup, find_packages

setup(
    name='introduction-to-tdd-with-django',
    packages=find_packages(),
    version='0.1',
    description='Introduction to TDD with Django.',
    author='Justin Beall',
    author_email='jus.beall@gmail.com',
    keywords=['dev3l', 'python', 'tdd', 'django'],
    install_requires=[
        'django',
        'selenium',
        'pytest'
    ],
    classifiers=[
        'Environment :: Console',
        'Intended Audience :: Developers',
        'License :: OSI Approved :: MIT License',
        'Operating System :: OS Independent',
        'Programming Language :: Python',
        'Programming Language :: Python :: 3',
        'Topic :: Software Development :: Libraries :: Python Modules'],
)
