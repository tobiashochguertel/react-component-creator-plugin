# react-component-creator

![Downloads](https://img.shields.io/jetbrains/plugin/d/13965-react-component-creator?style=for-the-badge)
![Version](https://img.shields.io/jetbrains/plugin/v/13965-react-component-creator?style=for-the-badge)
![Rating](https://img.shields.io/jetbrains/plugin/r/rating/13965-react-component-creator?style=for-the-badge)


- An Brainstorm Plugin to create a new react functional component with all additional files like
LESS, Spec, Storybook.
- Add Redux reducer module with actions, mutations, state and types.
- Add custom templates to match your coding style and your needs.



#修改点

主要是针对项目做了适配修改，比如新增模板文件、测试文件单独存放等等

![image-20220423225506561](https://raw.githubusercontent.com/KingZhang/kingzhang.github.io/blog/source/assets/img/image-20220423225506561.png)

![image-20220423233459847](https://raw.githubusercontent.com/KingZhang/kingzhang.github.io/blog/source/assets/img/image-20220423233459847.png)

项目构建需要使用低版本idea库，高版本不兼容，ideaIU-2020.2.4.win  https://www.jetbrains.com/idea/download/other.html



# Custom Templates
If you are not happy with the predefined templates, you can choose your
own templates. The templates will be processed with mustache as templating.
All variables can also be used for the filenames.

Following variables are available


**Component**

| variable | Description |
|---|---|
| {{componentName}} | the inputted component name. Without any alterations |
| {{componentCamelcaseName}} | Camelcased input `my-component` becomes `MyComponent` |

**Reducer**

| variable | Description |
|---|---|
| {{actionFunctionName}} | Name of the function inside the `actions.ts` file |
| {{moduleName}} | Name of the folder |
| {{mutationType}} | String which will be used as type of the dispatch/mutation |
| {{moduleNamePascalCase}} | Pascalcased moduleName |
| {{stateName}} | Name for the state. `my-component` becomes `MyComponentState` |
| {{actionTypeName}} | Takes the input of `actionFunctionName` and capitalizes the first letter and appends `Action`. From `setData` becomes `SetDataAction` |
| {{actionTypesEnumName}} | Name used for the action types enum. actionTypesEnumName is the namespace where all `mutationType` actions are kept |


# Development
Follow the [Setup Instructions](./doc/DEVELOPMENT.md)

# Icons
Icons provided by https://www.iconfinder.com/justicon via https://www.iconfinder.com
