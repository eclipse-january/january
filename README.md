# The Eclipse January Project 

## What is this?

This is a library for handling Data in Java. It is inspired in part by [NumPy](http://www.numpy.org/) and aims to provide similar functionality.

The [Eclipse January](https://github.com/eclipse/january) project combines the core data structures projects of the following projects which originated the code.

* [Eclipse DAWNSci](https://github.com/eclipse/dawnsci)
* [Eclipse ICE](https://github.com/eclipse/ice)
* [Eclipse EAVP](https://github.com/eclipse/eavp)

## Why use it?

* **Familiar.** Provide familiar functionality, especially to NumPy users.
* **Robust.** Has test suite and is used in production heavily at [Diamond Light Source](http://www.diamond.ac.uk/) and [Oak Ridge National Laboratory](https://www.ornl.gov/)
* **No more passing double[].** IDataset provide a consistent object for basing APIs on with significantly improved clarity over using double arrays or similar.
* **Optimized.** Optimized for speed and getting better all the time.
* **Scalable.** Allows handling of data sets larger than available memory with ["Lazy Datasets"](org.eclipse.january/src/org/eclipse/january/dataset/ILazyDataset.java).
* **Focus on your algorithms.** By reusing this library it allows you to focus on your code.

## Getting Started

Clone the examples repository and have a look. Browse over to the [examples](org.eclipse.january.examples) for more information.

## Javadocs

The current Javadocs are published here http://jonahkichwacoders.github.io/org.eclipse.dataset/javadoc/

## Contributing

See the [contribution guide](CONTRIBUTING.md) for information on contributing to the Eclipse January Project.

## License

The code is distributed under the [Eclipse Public License](LICENSE).
