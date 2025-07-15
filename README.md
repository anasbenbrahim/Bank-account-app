# 🏦 Bank Account App — Learn Microservices with Spring Boot & Spring Cloud

## 📚 Overview

**`bank-account-app`** est une application pédagogique pour apprendre l’architecture **microservices** avec **Spring Boot** et **Spring Cloud**.  
Elle simule un système bancaire de gestion des clients et des comptes, tout en mettant en œuvre :

- Découverte de services (**Eureka**)
- Routage des requêtes via une passerelle API (**Spring Cloud Gateway**)
- Gestion centralisée de la configuration (**Spring Cloud Config Server**)

## 🧩 Core Components

### 🧑‍💼 Customer Service

- Gère toutes les opérations liées aux clients.
- Expose des API REST pour créer, mettre à jour et consulter des informations clients.
- Communique avec le **Account Service** via **Open Feign**.

### 💰 Account Service

- Gère les opérations sur les comptes bancaires (*Current Account*, *Saving Account*).
- Statuts possibles : **CREATED**, **ACTIVATED**, **SUSPENDED**, **BLOCKED**.
- Permet :
  - Création de compte
  - Consultation et modification
  - Débit et crédit
  - Transfert de solde
  - Historique des transactions

### 🔍 Eureka Service (Discovery Service)

- Sert de **serveur de découverte** pour tous les microservices.
- Chaque service s’enregistre dynamiquement et peut découvrir les autres.

### 🚪 Spring Cloud Gateway

- Sert de **passerelle API** pour router les requêtes entrantes vers les services appropriés.
- Simplifie la gestion des points d’accès clients.

### ⚙️ Config Service

- Fournit une **gestion centralisée de la configuration**.
- Chaque microservice récupère ses paramètres dynamiques depuis ce serveur.
- Facilite les mises à jour de configuration sans redeploiement.

---

## 🔗 Interactions

- **Clients** : Interagissent uniquement via la **Gateway**.
- **Découverte de services** : Tous les services s’enregistrent et se découvrent dynamiquement via **Eureka**.
- **Configuration** : Les services récupèrent leurs configurations depuis le **Config Service**.
- **Communication interne** : `Customer Service` et `Account Service` utilisent **REST Open Feign**.
- **Opérations supportées** :
  - Création de compte
  - Consultation, modification
  - Débit, crédit, transfert
  - Historique des transactions

---

## 📂 Project Structure & Dependencies

### ✅ Customer & Account Services

- **Spring Web** : pour exposer des APIs REST.
- **Spring Data JPA** : pour les opérations CRUD sur la base de données.
- **H2 Database** : base en mémoire pour le développement.
- **Lombok** : pour réduire le code boilerplate.
- **Eureka Discovery Client** : pour l’enregistrement et la découverte des services.
- **Spring Boot Actuator** : pour le monitoring.

### ✅ Eureka Service

- **Eureka Server** : pour gérer l’annuaire des services.
- **Spring Boot Actuator**

### ✅ Gateway Service

- **Spring Cloud Gateway** : routage réactif des requêtes.
- **Eureka Discovery Client**
- **Spring Boot Actuator**

### ✅ Config Service

- **Spring Cloud Config Server** : gestion centralisée des configurations.
- **Eureka Discovery Client**
- **Spring Boot Actuator**

---

## 🚀 Setup & Run

1. **Cloner le dépôt**

   ```bash
   git clone https://github.com/yourusername/bank-account-app.git
   cd bank-account-app
   
⚙️ Prérequis

- Java 17
- Maven 3.8+

2. **Build du projet**

   ```bash
    mvn clean install

3. **Démarrer les services**

   ```bash
    docker compose up -d --build
  
