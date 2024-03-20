# ms-product
Technical challenge for tekton


#### Installation instructions

1. Clone Repo 
`git clone https://github.com/julianmojico/ms-product.git`
2. Install dependencies
   `gradle build`
3. Run Unit tests with `gradle test`
4. Start the application
   `gradle bootRun`
5. You can also import IntelliJIdea project files in .idea and run from your IDE

- The application will start embedded h2 db service, create product table and insert sample product. Find SQL statements in **/src/main/resources/data.sql**
- Find the application logs in **application.log**
- Find datasources and other spring configs in **application.properties**
- Find h2 admin console where you can check db status, run SQL statements and more. Default credentials can be viewed/changed in previous mentioned file:
http://localhost:8080/h2-console/
- Find REST API documentation in SwaggerUI:
http://localhost:8080/swagger-ui/index.html#/

**
h2 admin**
![image](https://github.com/julianmojico/ms-product/assets/12740590/1cd181a2-131b-4e29-84d5-a1c310f9ce07)


#### Infraestructure


##### Provisioning: AWS Beanstalk
AWS Elastic Beanstalk is a Platform-as-a-Service (PaaS) offering from Amazon Web Services (AWS) that makes it easy to deploy and manage applications in the cloud. Elastic Beanstalk handles the deployment, scaling, and monitoring of your application infrastructure, allowing you to focus on building and running your application.

![image](https://github.com/julianmojico/ms-product/assets/12740590/53876c36-3df4-4e46-b78e-700854136766)


##### Auto-scaling
Auto Scaling: Elastic Beanstalk automatically scales your application based on demand, allowing it to handle fluctuations in traffic without manual intervention.
In this case, the implementation of this polity is to add one more instance when average Network load is higher than than 60.000 bytes within a 5 minutes window, up to 3 instances.
Take into consideration that this setup is for a t3.micro and t3.small instances.

##### Monitoring
Beanstalk offers embedded Monitoring strategy for most important metrics.
In this case the parameters elections are: CPU, InstanceHealth, Request ammount 3xx, 4xx, 5xx.
When the threshold is overcome, notification emails are sent by email.

Instance scaling

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2de33e44-a367-4741-af18-cd73d6f88cda/b3207593-e178-4426-bd73-87e8ac82024b/Untitled.png)

Environment monitoring

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2de33e44-a367-4741-af18-cd73d6f88cda/a034a916-b5a2-4275-835b-bc3dd58b56ed/Untitled.png)


Instance Monitoring:

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2de33e44-a367-4741-af18-cd73d6f88cda/59d7c958-fbef-4e26-aa75-7c46082e0f2d/Untitled.png)



1.8.2. Sustentar la estrategia de Monitoreo.
1.8.3. Breve descripción de los patrones utilizados.
1.8.4. Diagrama de arquitectura usada en el proyecto.
1.8.5. Diagrama de Infraestructura.
1.8.6. Instrucciones para levantar el proyecto localmente.
1.8.7. Información adicional que el candidato considere relevante.



##### References:
https://www.baeldung.com/spring-boot-h2-database  
https://medium.com/@bubu.tripathy/best-practices-creating-repository-interfaces-with-jpa-d904bee64397  
https://www.baeldung.com/exception-handling-for-rest-with-spring  
https://salithachathuranga94.medium.com/validation-and-exception-handling-in-spring-boot-51597b580ffd
https://www.baeldung.com/spring-rest-openapi-documentation
https://medium.com/@itasyurt/how-to-customize-caches-with-spring-spring-boot-de801d5ecf38
https://www.baeldung.com/spring-invoke-cacheable-other-method-same-bean
https://www.baeldung.com/rest-template
TODO Pageable: https://www.baeldung.com/spring-rest-openapi-documentation
