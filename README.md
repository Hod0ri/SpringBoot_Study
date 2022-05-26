# SpringBoot_Study

## DI(Dependency Injection)
> 객체를 직접 생성하는 것이 아닌, 외부에서 생성하여 주입시키는 방식

![](https://media.discordapp.net/attachments/852606355407896576/979403751196606484/unknown.png?width=733&height=302)

좌측 케이스의 경우에는 객체 내부에서 다른 객체를 new 생성자를 통해 생성한 경우이며,  
우측 케이스의 경우에는 객체 외부에서 다른 객체를 생성자나 Setter 메서드로 생성한 경우이다.  

우측 케이스를 의존성 주입(DI)의 예시이다.  
이런 식으로 외부로 빼내서 주입하는 방식을 사용하게 되면, 모듈 간 결합도가 낮아지고 유연성이 높아진다.  
그리 되면 코드의 수정이 쉬워지며, 테스트 코드 작성이 쉬워진다.  

IoC를 실현하는데, DI가 필수적으로 들어가며, 객체 생명 주기 같은 프로그램 제어를 프레임워크가 알아서 하도록 넘길 수 있다.

```java
class Application {
    private OperationSystem osys;

    publiv Application() {
        this.osys = new OperationSystem();
    }

    public StartDevice() {
        this.osys.onBoot();
    }
}
```
위 코드의 경우는 onBoot 메서드를 호출 하기 위하여 OperationSystem 클래스가 필요하다.  
이때, Application 클래스는 OperationSystem 클래스의 의존성을 가지게 된다.  

하지만, 의존성을 Program 클래스 내에서 생성한다.  

```java
class Application {
    private IOperationSystem osys;

    @Autowired
    publiv Application(IOperationSystem osys) {
        this.osys = osys;
    }

    public StartDevice() {
        this.osys.onBoot();
    }
}
```
IOperationSystem이라는 인터페이스를 Application에 주입을 한다.  
인터페이스에 전달이 되어, 객체가 변화하더라도 Application의 변경은 필요가 없어지게 된다.  
단지, IOperationSystem에 어떤 클래스를 전달 할 지만 개발자가 지정하면 된다.

## Ioc(Inversion of Control)

## AOP (Aspect Oriented Programming)
