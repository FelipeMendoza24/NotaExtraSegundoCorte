# Felipe Mendoza
# Parcial 1
## I. (25%) MEMORIA

<a href="https://ibb.co/WVQw8sZ"><img src="https://i.ibb.co/mNmwZSk/image.png" alt="image" border="0"></a>

## DISEÑO

<a href="https://ibb.co/Jj3TMxz"><img src="https://i.ibb.co/gZ48BvD/sequence-diagram-1.png" alt="sequence-diagram-1" border="0"></a>


## CONCEPTOS

### 1. ¿Qué es encapsulamiento? ¿Qué ventajas ofrece?
#### Respuesta:
* **El encapulamiento es cuando se limita el acceso a las variables/atributos de una clase, con el fin de controlar quien tiene acceso a ella desde otra clase. Con los setters y getters de cada variable, logramos hacer este encapsulamiento. Esto ofrece multiples ventajas, una de estas es, como lo dije anteriormente, limitar el acceso a las variables de un objeto, para evitar cambios o daños a esta clase. Al privatizar algunos atributos, nos permite hacer cambios sin alterar el modo en como los usuarios utilizan el código.**

### 2. ¿Qué es ocultación de información? ¿Por qué aplicarla? ¿Cómo se implementa en Java?

#### Respuesta:
* **La ocultación de informacion es aislamiento de un objeto, con el fin de proteger las propiedades de este, ya que cada uno de estos tiene funciones definidas para modificarlos, de esta manera quien no tenga estas funciones, no puede modificarlo y asi se protege. Se debe aplicar para evitar futuros problemas ya que este objeto no puede cambiar de forma inesperada, lo que causaria errores en el programa. A traves del nivel de acceso privado para el atributo, y crando getter y setter para este, ya que estas son como las llaves de acceso para poder interactuar con el.**


# Parcial 2

## DISEÑANDO
### Diagrama de clases

![image](https://user-images.githubusercontent.com/78186138/115966633-2e423b00-a4f4-11eb-8fed-6b67f7f62132.png)

### Diagramas de secuencia

#### 1)
![image](https://user-images.githubusercontent.com/78186138/115965984-1ae1a080-a4f1-11eb-9a33-d9541316b677.png)

#### 2)
![image](https://user-images.githubusercontent.com/78186138/115966021-567c6a80-a4f1-11eb-8e67-22bf41ef7f16.png)


## EXTENDIENDO
### Diagrama de clases

![image](https://user-images.githubusercontent.com/78186138/115973822-817cb380-a51d-11eb-927d-cf81c7864076.png)

### De los diseños resultantes del punto I y II, ¿Qué debe cambiar? ¿Qué no debe cambiar?. Justifique su respuesta.
* Del punto uno, cambia el diseño, porque la duración de una actividad ya no es tan fácil como mirar sus pasos o sus preguntas sino que hay que calcular la duración de todas sus dependencias y sumarle la duración de la actividad. 
* Del punto dos, no toca cambiar nada porque el método getDuration de actividad, ha cambiado para incluir la duración de las dependencias y aunque el método se comporte diferente, lo que hace el sintetizador es llamar al método getActivityDuration. Entonces estos diagramas no hubiesen tenido que cambiar y el código tampoco.
### Teniendo en cuenta los cambios necesarios ¿Que fue bueno y que fue malo de su diseño?
* Algo que fue malo, fue el getEstimatedEndDate(), ya que este podria ser un atributo de cada actividad y no un metodo, lo cual haria todo un poco más facil.
* Algo bueno del diseño fue que no tuvo que cambiar mucho en el punto dos, esto quiere decir que el diseño fue acertado y se tuvo en cuenta posibles modificaciones o cosas que agregar a futuro.


## CONCEPTOS
### ¿Cuáles son las acciones los tres momentos importantes de las excepciones? ¿Cuál es el objetivo de cada una? ¿Cómo se implementa en Java cada acción?
* Las tres acciones mas importantes de las excepciones son: 1) **Cuando estas se lanzan.** 2) **Cuando se propagan.** 3) **Cuando se capturan.** 
* La primera funciona a través de la palabra reservada Throws, esta palabra va después de la declaración normal de cualquier otro método. 
Luego de esta palabra, se declara que excepción/es va a lanzar. Si el método puede lanzar más de una excepción, se ponen los nombres de todas separados por comas. 
(Para crear nuevas excepciones, debemos crear las clases de estas que hereden de Exception y declarar sus constructores). 
Clase en donde se utilizará la excepcion:
```java
public class SabanaPayrollExceptions extends Exception{
    public static final String NONEXISTENT_EMPLOYEE = "This employee doesn't exist";

    public SabanaPayrollExceptions(String message) {
        super(message);
    }

}
```
Clase en donde se utilizará la excepcion:
```java
public double calculateEmployeeSalary(UUID id) throws SabanaPayrollExceptions{
        Employee employee = findEmployee(id);

        if (employee == null)
            throw new SabanaPayrollExceptions(SabanaPayrollExceptions.NONEXISTENT_EMPLOYEE);

        return employee.calculateSalary();
    }
```
* En la segunda tiene el objetivo de que cuando se produce una excepción, la máquina virtual empieza a buscar codigo para tratar la excepcion, si esta no encuentra el código en 
el método actual, esta se propaga hacia el método que lo haya invocado y se busca allí el código que la trate. Si este tampoco lo tiene, se propagará a su vez al que lo haya 
invocado, y así sucesivamente hasta encontrar un método con try y catch o throws new que trate la excepción. 
```java
public Triangle(double side1, double side2, double side3) throws ShapeException {

        if (side1 <= 0 || side2 <= 0 || side3 <= 0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
```
* Y por ultimo, capturarla consiste en Con las palabras reservadas, try y catch se puede capturar la excepción. Try es el encargado de probar que el bloque de código tenga o
no excepciones. En caso de que se produzca la excepción, Catch (que recibe como argumento throwable) se encarga de manejarlo, normalmente mostrando un mensaje de que ha causado 
el error. Un try puede tener más de un catch.
El siguiente ejemplo es para un Test pero funciona exactamente igual, dentro de try pone el bloque de código donde pudiera saltar un error y en catch, el error que saldria de parametro y como tratarlo.
```java
    public void shouldNorCreateCircleWithRadiusNegative() {

        try {
            new Circle(-1);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }
```
### ¿Qué es sobre-escritura de métodos? ¿Por qué aplicarla? ¿Cómo impedir que se sobre-escriba un método?
* La Sobre-escritura de métodos es la forma por la cual una clase que hereda puede re-definir los métodos de su super clase, de esta manera puede crear nuevos métodos con las mismas
caracteristicas pero se le agrega o modifica la funcionalidad del metodo.
* Esta se aplica con el fin de heredar un metodo de la superclase y utilizar su funcionalidad pero haciendolo mas especifico para lo que la subclase necesita. De esta forma no
tendremos que crear otro metodo en la subclase, ni cambiar el metodo de la superclase que tal vez no aplique para esta.
* Para evitar que se sobre-escriba un metodo debemos declararlo como private, para que esta solo sea visible en su propia clase y no en sus subclases y asi no poderla sobre-escribir.
Si queremos que este metodo sea visible para solo la clase y sus subclases, se utiliza protected. Tmabien se puede usar la palabra reserbada final, para evitar que se sobreescriba ya que las subclases
no lo pueden implementar.









