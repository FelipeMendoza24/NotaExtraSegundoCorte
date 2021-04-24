# Felipe Mendoza Parcial

## DISEÑANDO
### Diagrama de clases
* ![image](https://user-images.githubusercontent.com/78186138/115094352-d64b7900-9ee2-11eb-94e9-f05a6c41502a.png)
### Diagrama de secuencia
* ![image](https://user-images.githubusercontent.com/78186138/115094925-fe3bdc00-9ee4-11eb-8b25-b7cedfd6809a.png)

## EXTENDIENDO
### Diagrama de clases
* ![image](https://user-images.githubusercontent.com/78186138/115094352-d64b7900-9ee2-11eb-94e9-f05a6c41502a.png)

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









