# Java Validation Library & Design Patterns

A comprehensive Java library designed for user object validation, demonstrating robust object-oriented software design principles, clean code standards, and key GoF design patterns.

## 📌 Project Overview
This library provides a flexible validation framework for managing and validating `User` objects, supporting multiple user types (`BasicUser`, `PremiumUser`, `PlatinumUser`). It leverages functional interface patterns in Java to allow clean, composable, and chainable validation rules.

## 🛠 Architectural & Design Patterns Implemented
- **Combinator Pattern**: Implemented in `UserValidation` interface to provide chainable and composable validation methods (`and`, `or`, `xor`, `all`, `none`, etc.).
- **Factory Method Pattern**: Implemented in `UserFactory` for encapsulated creation of various `User` sub-types.
- **Template Method Pattern**: Implemented via static sorting utility in `UserUtils` utilizing `Comparator<T>`.

## 📐 Project Structure & Package Standards
- **Package**: `il.ac.hit.validation`
- Core Entities: `User`, `BasicUser`, `PremiumUser`, `PlatinumUser`
- Validation Framework: `UserValidation`, `ValidationResult`
- Utilities & Factories: `UserFactory`, `UserUtils`

## ⚙️ Key Coding & Quality Standards
- **Encapsulation**: Constructors delegate field assignments directly to setter methods.
- **Interface Segregation**: Variable declarations prefer interface types for loose coupling.
- **Documentation & Comments**: Full JavaDoc (`/** ... */`) coverage for classes, interfaces, enums, methods, and fields, alongside granular C++ style inline comments (`//`).
- **Naming Conventions**: Strict adherence to `CamelCase` for classes/interfaces and `camelCase` for methods/variables.
