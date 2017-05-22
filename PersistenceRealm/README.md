MyBook
==================

App que realiza as operações básicas (CRUD) de um banco de dados, utilizando a biblioteca Realm para persistência de dados.

## Realm
- Adicionar dependência  no build.gradle (Project: )
 
	...
	buildscript {
		repositories {
			jcenter()
		}
		dependencies {
			...
			classpath 'io.realm:realm-gradle-plugin:1.2.0'
			...
		}
	}
	...

- Adicionar dependência  no build.gradle (Module: app)

	...
	apply plugin: 'realm-android'
	...

## IDE 
- Android Studio 2.4 Preview 3

## Requisitos
- Java 1.8
- Gradle 3.4.1

## Versão Plataforma 
- Ideal: Android 7.1 (Nougat) - API 25
- Mínima: Android 5.1 (Lollipop) - API 22