<script setup>

import { storeToRefs } from "pinia";
import { usePostStore } from "@/stores/post";

import PostCard from "@/components/card/PostCard.vue";

const store = usePostStore();
const { posts } = storeToRefs(store);

</script>

<template>
  <section class="content-top">
    <div>
      <h1>Template blog made with vue.</h1>
      <p>
        Lorem ipsum dolor sit, amet consectetur adipisicing elit. Corporis
        itaque harum illum, ut reprehenderit, nesciunt quam fuga, voluptates
        nihil temporibus fugit expedita? Placeat optio iusto aperiam, aliquam
        eveniet consequatur reiciendis?
      </p>
    </div>
    <img class="header-image" src="@/assets/images/logo.svg" />
  </section>

  <h3>Latest Posts</h3>
  <div class="post-container">
    <PostCard
      v-for="post in posts"
      :key="post.id"
      :id="post.id"
      :image="post.image"
      :title="post.title"
      :date="post.date"
      class="post-card"
    />
  </div>
  <h3>Popular</h3>
  <div class="post-container">
    <PostCard
      v-for="post in posts"
      :key="post.id"
      :id="post.id"
      :image="post.image"
      :title="post.title"
      :date="post.date"
      class="post-card"
    />
  </div>
</template>

<style scope>
.content-top {
  width: 100%;
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}
.header-image {
  width: 150px;
  height: 150px;
  margin-left: 60px;
}
.category-container {
  display: flex;
  width: max-content;
  margin-bottom: 50px;
}
.category-card {
  margin-right: 40px;
}
.post-container {
  margin-bottom: 50px;
}
.post-card {
  margin-bottom: 15px;
}
</style>
