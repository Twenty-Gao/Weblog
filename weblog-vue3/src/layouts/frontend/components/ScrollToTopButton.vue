<template>
    <!-- fixed 固定位置，并通过 bottom-xx right-xx 设置在右下角 -->
    <div v-show="showScrollToTopBtn" @click="scrollToTop"
        class="border cursor-pointer fixed bottom-2 right-2 md:bottom-20 md:right inline p-3 bg-white hover:bg-gray-100 rounded">
        <svg t="1720708730154" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4256" width="20" height="20"><path d="M480 896V250.4L237.6 493.6 192 448l274.4-274.4L512 128l45.6 45.6L832 448l-45.6 45.6L544 250.4V896h-64z" p-id="4257"></path></svg>
    </div>
</template>

<script setup>
import { ref, onMounted, onBeforeUnmount } from 'vue'

// 是否展示返回顶部按钮
const showScrollToTopBtn = ref(false)

// 添加滚动监听
onMounted(() => window.addEventListener('scroll', handleScroll))

// 移除滚动监听
onBeforeUnmount(() => window.removeEventListener('scroll', handleScroll))

const handleScroll = () => {
    // 如果页面滚动超过300px，显示回到顶部按钮，否则隐藏
    showScrollToTopBtn.value = window.scrollY > 300
}

// 滚动到顶部
const scrollToTop = () => {
    window.scrollTo({
        top: 0, // 距离顶部位置
        behavior: 'smooth' // 平滑滚动效果
    });
}
</script>
