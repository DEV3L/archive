from setuptools import setup, find_packages

setup(
        name='python-office-coffee-algorithm',
        packages=find_packages(),
        version='0.1',
        description='A recursive algorithm that defines office coffee etiquette',
        author='Justin Beall',
        author_email='jus.beall@gmail.com',
        url='https://github.com/DEV3L/python-office-coffee-algorithm',
        download_url='https://github.com/DEV3L/python-office-coffee-algorithm/tarball/0.1',
        keywords=['dev3l', 'python', 'coffee'],
        install_requires=[
            'Faker'
        ],
        classifiers=[
            'Environment :: Console',
            'Intended Audience :: Developers',
            'License :: OSI Approved :: MIT License',
            'Operating System :: OS Independent',
            'Programming Language :: Python',
            'Programming Language :: Python :: 2',
            'Programming Language :: Python :: 3',
            'Topic :: Software Development :: Libraries :: Python Modules'],
)
