# Design Patterns

Os padrões de design de projeto são **soluções para problemas comuns** que ocorrem durante o desenvolvimento e manutenção de software.

## GoF
GoF (Gang of Four) é um padrão de projeto de software proposto por Erich Gamma, Richard Helm, Ralph Johnson e John Vlissides em seu livro **"Design Patterns: Elements of Reusable Object-Oriented Software"**.  
O livro foi publicado em 1994 e é frequentemente referido como o "Livro dos Padrões de Projeto".

## Padrões de Criação
Os padrões de criação são projetados para lidar com mecanismos de criação de objetos.  
Eles tentam criar objetos de uma maneira adequada à situação específica.

### Singleton

O Singleton é um padrão de design que restringe a instância de uma classe a um único objeto.  
Isso é útil quando exatamente um objeto é necessário para coordenar ações em todo o sistema.

```java
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}
```

### Factory Method

O Factory Method é um padrão de design que define uma interface para criar um objeto, mas permite que as classes decidam qual classe instanciar. O Factory Method permite que uma classe adie a instanciação para subclasses.

```java
public interface Product {
    void operation();
}

public class ConcreteProduct implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProduct.operation()");
    }
}

public abstract class Creator {
    public abstract Product factoryMethod();
}

public class ConcreteCreator extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}
```

### Abstract Factory

O Abstract Factory é um padrão de design que fornece uma interface para criar famílias de objetos relacionados ou dependentes sem especificar suas classes concretas.

```java

public interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

public class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB1();
    }
}

public class ConcreteFactory2 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB2();
    }
}
```

### Builder

O Builder é um padrão de design que permite a construção de objetos complexos passo a passo. Ele também permite a representação do mesmo processo de construção, criando diferentes tipos de objetos.

```java
public class Product {
    private String part1;
    private String part2;

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }
}

public interface Builder {
    void buildPart1();
    void buildPart2();
    Product getResult();
}

public class ConcreteBuilder implements Builder {
    private Product product = new Product();

    @Override
    public void buildPart1() {
        product.setPart1("part1");
    }

    @Override
    public void buildPart2() {
        product.setPart2("part2");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildPart1();
        builder.buildPart2();
        return builder.getResult();
    }
}
```

### Prototype

O Prototype é um padrão de design que permite a clonagem de objetos, mesmo que suas classes concretas sejam desconhecidas. O padrão especifica os tipos de objetos a serem criados usando uma instância prototípica e cria novos objetos copiando esse protótipo.

```java

public abstract class Prototype implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ConcretePrototype extends Prototype {
    private String field;

    public ConcretePrototype(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}

public class Client {
    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype operation() {
        try {
            return (Prototype) prototype.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

public static void main(String[] args) {
    Prototype prototype = new ConcretePrototype("field");
    Client client = new Client(prototype);
    Prototype clone = client.operation();
    System.out.println(clone.getField());
}
```

## Padrões Estruturais

Os padrões estruturais são projetados para simplificar o design do sistema, identificando uma maneira simples de realizar relacionamentos entre entidades.

### Adapter

O Adapter é um padrão de design que permite objetos com interfaces incompatíveis colaborarem. Ele permite que objetos com interfaces incompatíveis trabalhem juntos.

```java

public interface Target {
    void request();
}

public class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee.specificRequest()");
    }
}

public class Adapter implements Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
```

### Bridge

O Bridge é um padrão de design que desacopla uma abstração de sua implementação, de modo que as duas possam variar independentemente.

```java

public interface Implementor {
    void operation();
}

public class ConcreteImplementorA implements Implementor {
    @Override
    public void operation() {
        System.out.println("ConcreteImplementorA.operation()");
    }
}

public class ConcreteImplementorB implements Implementor {
    @Override
    public void operation() {
        System.out.println("ConcreteImplementorB.operation()");
    }
}

public abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}

public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        implementor.operation();
    }
}
```

### Composite

O Composite é um padrão de design que permite compor objetos em estruturas de árvore para representar hierarquias parte-todo. O Composite permite que os clientes tratem objetos individuais e composições de objetos de maneira uniforme.

```java

public interface Component {
    void operation();
}

public class Leaf implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf.operation()");
    }
}

public class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        for (Component child : children) {
            child.operation();
        }
    }
}
```

### Decorator

O Decorator é um padrão de design que permite adicionar comportamento a objetos individuais, mas mantém a estrutura de objetos intacta.

```java

public interface Component {
    void operation();
}

public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("ConcreteComponent.operation()");
    }
}

public abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("ConcreteDecoratorA.operation()");
    }
}

public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("ConcreteDecoratorB.operation()");
    }
}
```

### Facade

O Facade é um padrão de design que fornece uma interface simplificada para uma biblioteca, um framework ou um conjunto de interfaces de um subsistema complexo.

> É um pouco controverso, pois pode ser considerado um anti-padrão.

```java

public class SubsystemA {
    public void operationA() {
        System.out.println("SubsystemA.operationA()");
    }
}

public class SubsystemB {
    public void operationB() {
        System.out.println("SubsystemB.operationB()");
    }
}

public class Facade {
    private SubsystemA subsystemA = new SubsystemA();
    private SubsystemB subsystemB = new SubsystemB();

    public void operation() {
        subsystemA.operationA();
        subsystemB.operationB();
    }
}
```

### Flyweight

O Flyweight é um padrão de design que minimiza o uso de memória ou custo computacional compartilhando o máximo possível com objetos similares.

```java

public interface Flyweight {
    void operation();
}

public class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation() {
        System.out.println("ConcreteFlyweight.operation()");
    }
}

public class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String intrinsicState) {
        if (!flyweights.containsKey(intrinsicState)) {
            flyweights.put(intrinsicState, new ConcreteFlyweight(intrinsicState));
        }
        return flyweights.get(intrinsicState);
    }
}
```

### Proxy

O Proxy é um padrão de design que fornece um substituto ou marcador para outro objeto. Um proxy controla o acesso ao objeto original, permitindo que você faça algo antes ou depois do pedido.

```java

public interface Subject {
    void request();
}

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject.request()");
    }
}

public class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}
```

## Padrões Comportamentais

[TODO]