import './assets/main.css'
import 'nprogress/nprogress.css'
// 引入全局状态管理 Pinia
import pinia from '@/stores'
// 导入 Element Plus 图标
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import { createApp } from 'vue'
import App from '@/App.vue'//引入App.vue组件
// 导入路由
import router from '@/router'
import 'animate.css';
// 导入全局路由守卫
import '@/permission'
// 引入全局状态管理 Pinia
import { createPinia } from 'pinia'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
// 图片点击放大
import 'viewerjs/dist/viewer.css'
import VueViewer from 'v-viewer'


const app = createApp(App)
// const pinia = createPinia()
// pinia.use(piniaPluginPersistedstate)
// 引入图标
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
// 应用路由
app.use(router)
// 创建应用，并将 App 根组件挂载到 <div id="#app"></div> 中

// 应用 Pinia
app.use(pinia)
app.use(VueViewer)

app.mount('#app')