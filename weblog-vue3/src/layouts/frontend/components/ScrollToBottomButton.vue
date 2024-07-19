<template>
    <!-- fixed 固定位置，并通过 bottom-xx right-xx 设置在右下角 -->
    <div v-show="showScrollToBottomBtn" @click="scrollToBottom"
        class="border cursor-pointer fixed bottom-2 right-2 inline p-3 bg-white hover:bg-gray-100 rounded">
        <svg t="1720707863776" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4258" width="20" height="20"><path d="M480 160a32 32 0 0 1 64 0v672a32 32 0 0 1-64 0z" p-id="4259"></path><path d="M745.28 585.28a32 32 0 0 1 45.44 45.44l-256 256a32 32 0 0 1-45.44 0l-256-256a32 32 0 1 1 45.44-45.44L512 818.88z" p-id="4260"></path></svg>
    </div>
</template>

<script setup>
import { ref, onMounted, onBeforeUnmount } from 'vue'

// 是否展示返回顶部按钮
const showScrollToBottomBtn = ref(true)
// 添加滚动监听
onMounted(() => window.addEventListener('scroll', handleScroll))

// 移除滚动监听
onBeforeUnmount(() => window.removeEventListener('scroll', handleScroll))

const handleScroll = () => {
    // 获取文档的总高度
   const totalHeight = document.body.scrollHeight;
    console.log(window.scrollY,totalHeight)
    // 如果页面滚动超过300px，显示回到顶部按钮，否则隐藏
    showScrollToBottomBtn.value = !(window.scrollY > totalHeight-1500)
}

// 滚动到顶部
const scrollToBottom = () => {
   // 获取文档的总高度
   const totalHeight = document.body.scrollHeight;
    
    // 滚动到文档底部
    window.scrollTo({
        top: totalHeight, // 滚动到文档的底部
        behavior: 'smooth' // 平滑滚动效果
    });

}
</script>
