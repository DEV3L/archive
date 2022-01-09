from setuptools import setup, find_packages

setup(
    name='',
    packages=find_packages(),
    version='0.1.0',
    description='Talk Python To Me - Python for Entrepeneurs - Intro App',
    author='Justin Beall',
    author_email='jus.beall@gmail.com',
    keywords=['dev3l', 'talk-python-to-me-courses'],  # arbitrary keywords
    install_requires=[
        'colorama',
    ],
    classifiers=[
        'Environment :: Console',
        'Intended Audience :: Developers',
        'License :: OSI Approved :: MIT License',
        'Operating System :: OS Independent',
        'Programming Language :: Python',
        'Programming Language :: Python :: 3',
        'Programming Language :: Python :: 3.3',
        'Programming Language :: Python :: 3.4',
        'Programming Language :: Python :: 3.5',
        'Topic :: Software Development :: Python Training'],
)