# Parcial 2 Arep

## Arquitectura

Se requiere diseñar uun prototipo que tenga una servicio para computar funciones de ordenamiento, especificamente con dos algoritmos de busqueda, Binary Search y Linear Search siendo desplegado en dos instancias de Math Service independientes con las mismas funciones, con la particularidad de que ewstas se comunican con un servidor proxy el cual cuenta con un algoritmo de balanceo llamado roundrobin, donde este este mismo se encarga de repartir las solicitudes del cliente de forma asincron y hacer las consultas a Math service.

![img.png](src/main/resources/images/img.png)

## Despliegue AWS y controladores 

Se crearon dos proyectos Server, Math Server donde el primero actua como servidor proy usando round robin para hacer consultas a las dos instancias de math service 

![img.png](src/main/resources/images/img1.png)
![img_1.png](src%2Fmain%2Fresources%2Fimages%2Fimg_1.png)

El segundo es Math server el cual implementa las busquedas tanto binaria como lineal

![img.png](src/main/resources/images/img2.png)![img_2.png](src%2Fmain%2Fresources%2Fimages%2Fimg_2.png)