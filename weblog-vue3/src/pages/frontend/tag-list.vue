<template>
    <Header></Header>

    <!-- 主内容区域 -->
    <main class="container max-w-screen-xl mx-auto p-4 px-6">
        <!-- grid 表格布局，分为 4 列 -->
        <div class="grid grid-cols-4 gap-7">
            <!-- 左边栏，占用 3 列 -->
            <div class="col-span-4 md:col-span-3 mb-3">
               <TagArticleListCard></TagArticleListCard>
            </div>

             <!-- 右边侧边栏，占用一列 -->
             <aside class="col-span-4 md:col-span-1">
                <div class="sticky top-[5.5rem]">
                    <!-- 博主信息 -->
                    <UserInfoCard></UserInfoCard>

                    <!-- 分类 -->
                    <CategoryListCard></CategoryListCard>

                </div>
            </aside>
        </div>

    </main>

    <Footer></Footer>
</template>

<script setup>
import Header from '@/layouts/frontend/components/Header.vue'
import Footer from '@/layouts/frontend/components/Footer.vue'
import UserInfoCard from '@/layouts/frontend/components/UserInfoCard.vue'
import CategoryListCard from '@/layouts/frontend/components/CategoryListCard.vue'
import  TagArticleListCard from '@/layouts/frontend/components/TagArticleListCard.vue'
import { getTagList } from '@/api/frontend/tag'
import {ref}  from 'vue'
      // 所有标签
      const tags = ref([])
                getTagList().then((res) => {
                    if (res.success) {
                        tags.value = res.data
                    }
                })
          
</script>
