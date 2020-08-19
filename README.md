#MVP框架DEMO

记录下MVP的基础使用，实现的效果就是解耦，单元测试，多人高效开发，面向UI 定义IView接口，Presenter 桥接 Model，定义IPresenter，定义数据接口返回数据


时序交互
View --> Presenter --> Model --> Presenter --> View

BaseActivity 基类 实现了LoadingDialogFragment的统一管理

BasePresenter 基类 统一管理的IView 
