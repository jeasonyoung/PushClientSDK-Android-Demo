# PushClientSDK-Android-Demo
推送系统Android端SDK示例

## gradle 依赖方式引用
### 添加github私有仓库
repositories {
    jcenter()
    maven {
        url "https://raw.github.com/jeasonyoung/PushClientSDK-Android/master/maven-repo/"
    }
}

### 依赖引入
dependencies {
   compile 'com.linkus:PushClientSDK:1.1'
}

