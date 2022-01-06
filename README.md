# AirForm
*(Work in progress)*

### Application domain

Whenever you want to launch something into the air in the vicinity of an aerodrome, then you got some paperwork to do. Whether it's fireworks, lanterns, helium baloons or even laser or light show (drones are a different story), you need to coordinate that with Airspace Management Department of [PANSA](https://www.pansa.pl) by filing and sending corresponding form [form](https://www.pansa.pl/asm1/formularze-zgloszeniowe/). Then, ASM employee, after coordinating with aforementioned aerodrome authorities, will contact you back with terms and further actions needed for your undertaking. You may be cleared to proceed without any restrictions, sometimes you'll be requested to contact aerodrome tower some time before you start and in some rare events you will not get permisssion at all (security concerns).

### Why

Currently applying for permission is done by sending paper form exclusively. The fact that you can send it scanned via email doesn't help a lot. This calls for a full on digital solution. I decided to give it a try and try to implement my own service. Of course there's absolutely zero percent chance for this to become official, but still is a great learning opportunity.

### How
* Spring (Boot, Web, Security, Data, Validation)
* MySQL database
* Thymeleaf
* HTML + CSS (Bootstrap)

### Current progress
There are 3 types of accounts available. See table for functionalities and current project progress estimate. 

| Name      |Role| Progress                               |
|:---------:|:----:|-------------------------------------------|
| Applicant | Filing applications | ![ progress](https://progress-bar.dev/70) |
| Employee  | Processing applications| ![ progress](https://progress-bar.dev/15) |
| Admin     | Overal supervision | ![ progress](https://progress-bar.dev/0)  |

### Sample UI screenshots (click to enlarge)

<img alt="Applicant homepage" width="250" src="https://user-images.githubusercontent.com/58663723/148457231-7a8795e1-653c-4849-b2d7-11b916997fb3.jpg"> <img alt="Filled forms" width="250" src="https://user-images.githubusercontent.com/58663723/148457232-34a27140-4274-4c2f-83b5-207072ca8d52.jpg"> <img alt="Baloon form" width="250" src="https://user-images.githubusercontent.com/58663723/148457233-5f1a9b86-d748-480a-be03-aa546e53c9aa.jpg"> <img alt="Homepage" width="250" src="https://user-images.githubusercontent.com/58663723/148457234-f68fc28d-d254-477c-8d31-24f2957dd009.jpg">
