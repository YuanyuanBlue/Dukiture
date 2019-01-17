# Dukiture

Team project for ECE651 Spring 2018

## Overview
Our application is named Dukiture, which is aimed to help students and faculties in Duke community to sell and buy furniture. Our group works in agile. During this semester, we developed Dukiture application from front-end to back-end. In each step, we recorded our processes in documents.

## Overall Code Structure
```bash
.
├── main
│   ├── java
│   │   └── edu
│   │       └── duke
│   │           └── ece651
│   │               └── Dukiture
│   │                   ├── DukitureApplication.java
│   │                   ├── config
│   │                   │   ├── JWTAuthEntryPoint.java
│   │                   │   └── SecurityConfig.java
│   │                   ├── controller
│   │                   │   ├── ItemController.java
│   │                   │   ├── ItemRestController.java
│   │                   │   ├── UserController.java
│   │                   │   └── UserRestController.java
│   │                   ├── converter
│   │                   │   ├── ItemFormToItem.java
│   │                   │   └── ItemToItemForm.java
│   │                   ├── filter
│   │                   │   └── JWTAuthFilter.java
│   │                   ├── model
│   │                   │   ├── Item.java
│   │                   │   ├── ItemForm.java
│   │                   │   ├── Role.java
│   │                   │   └── User.java
│   │                   ├── repository
│   │                   │   ├── ItemRepository.java
│   │                   │   ├── RoleRepository.java
│   │                   │   └── UserRepository.java
│   │                   ├── service
│   │                   │   ├── ItemService.java
│   │                   │   ├── ItemServiceImpl.java
│   │                   │   ├── UserDetailServiceImpl.java
│   │                   │   ├── UserService.java
│   │                   │   └── UserServiceImpl.java
│   │                   ├── util
│   │                   │   ├── JWTConstants.java
│   │                   │   └── JWTUtil.java
│   │                   └── validator
│   │                       └── UserValidator.java
│   └── resources
│       ├── application.properties
│       └── templates
│           ├── error.html
│           ├── items
│           │   ├── image
│           │   │   ├── chair.jpeg
│           │   │   ├── f1.jpeg
│           │   │   ├── f2.jpeg
│           │   │   ├── f3.jpeg
│           │   │   └── s1.jpeg
│           │   ├── itemform.html
│           │   ├── list.html
│           │   └── show.html
│           ├── login.html
│           ├── profile.html
│           ├── registration.html
│           └── upload.html
└── test
    └── java
        └── edu
            └── duke
                └── ece651
                    └── Dukiture
                        ├── DukitureApplicationTests.java
                        ├── controller
                        │   └── itemControllerTest.java
                        ├── repository
                        │   ├── itemRepositoryTests.java
                        │   └── userRepositoryTest.java
                        └── service
                            ├── itemServiceComp.java
                            ├── itemServiceTest.java
                            ├── userServiceComp.java
                            └── userServiceTest.java
```

## Key APIs

Our APIs are implemented in `ItemController` and `UserController`. You can view
details there. We generated a JavaDoc for guiding through our methods. (You will need to first download and access our javadoc at /javadoc/index.html.)

## Getting Started

1.For Git Clone, go to https://gitlab.oit.duke.edu/tl200/Dukiture, and copy SSH.

![clone](/screenshots/W1.jpeg)

2.Then open the terminal and type ‘git clone’.

![clone](/screenshots/W2.jpeg)

3.Open IntelliJ IDEA, and click ‘import’.

![clone](/screenshots/W3.jpeg)

4.When import, please follow the instruction below step by step.

Open Dukiture/Dukiture file.

![clone](/screenshots/W4.jpeg)


5.Choose Maven

![clone](/screenshots/W5.jpeg)

6.Choose ‘Search for projects recursively’

![clone](/screenshots/W6.jpeg)

7.Just click next.

![clone](/screenshots/W7.jpeg)

![clone](/screenshots/W8.jpeg)

![clone](/screenshots/W9.jpeg)

8.Click ‘Finish’

![clone](/screenshots/W10.jpeg)

## Walking around Dukiture

1.Our login interface

![login](/screenshots/login.png)

2.We enforce the policy that only Duke NetID users can register.

![netid](/screenshots/netid.png)

The default password for your account is your netid.

3.After you login, you can change the password.

![change_password](/screenshots/change_password.png)

(Also, you can see your API key there.)

4.You can start creating a listing.

![create_listing](/screenshots/create.png)

5.Then you can see something in furniture list.

![list](/screenshots/list.png)

6.After creating a listing, you can also view your listing.

![view](/screenshots/view.png)

7.There is a search bar that you can type something to search the inventory. You can also sort by column.

That's it!

## Documents


### Requirements

https://docs.google.com/document/d/1Kw5x4iaQiGRVBq-1UxQ5D9YAfL0Fy3yzF3Ndb0jQdnI/edit?usp=sharing

### User Story and Architecture

https://docs.google.com/document/d/1ZTh3EMPJQtG1Z_yOqP2fAW1gp2YzJdfzFGB7a3pIrUU/edit?usp=sharing

### Project Plan

https://docs.google.com/document/d/1eEKZMVGBcO_5MgecgUTzl-jVqkf7ligijzYxjK66Dxw/edit?usp=sharing

### Milestone Slides

https://docs.google.com/presentation/d/1ZP6N3VwdYKHdZNX7NW-XLQc58PV9FPWMlvi11Z9nqCA/edit?usp=sharing

### Test Plan

https://docs.google.com/document/d/1vG6C-EOv9n_8t4A6iBWAnzT4cfo5LTQD4Zm7S_OVwjs/edit?usp=sharing

## Dependencies

We use Maven for dependency management. All of our imported libraries can be
found in `Dukiture/pom.xml`.

## References

[1] Login System: https://memorynotfound.com/spring-security-user-registration-example-thymeleaf/

[2] Login system: https://hellokoding.com/registration-and-login-example-with-spring-security-spring-boot-spring-data-jpa-hsql-jsp/

[3] Security: https://spring.io/guides/gs/securing-web/

[4] Forms & Models: https://github.com/springframeworkguru/spring-boot-mysql-example

[5] Login system: http://www.baeldung.com/spring-security-redirect-login

[6] Login system: https://stackoverflow.com/questions/23661492/implement-logout-functionality-in-spring-boot

[7] Upload file: https://spring.io/guides/gs/uploading-files/

[8] Database model:  https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/

[9] Duke NetID Login: https://apidocs.colab.duke.edu/?clientId=dukiture

[10] Duke NetID Login: https://gist.github.com/billhanyu/788358f01eea969b6d1dfd9fb0d87750

[11] Paper-js, we use it to style our app:  http://paperjs.org

[12] Search bar: https://www.w3schools.com/howto/howto_js_filter_table.asp

[13] Table Sorting: https://kryogenix.org/code/browser/sorttable/
