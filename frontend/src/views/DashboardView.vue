<script setup>
import { onMounted } from "vue";
import { uuid } from "vue-uuid";
import { storeToRefs } from "pinia";
import { usePostStore } from "@/stores/post";
import SampleMarkdown from "@/assets/markdown/sample.md";
import PostCard from "@/components/card/PostCard.vue";

const store = usePostStore();
const { posts } = storeToRefs(store);


const initPost = [
  {
    id: uuid.v1(),
    image: "node.png",
    title: "Front End Tables: Sorting, Filtering, and Pagination",
    date: "May 02",
    author: "blessedcrown",
    tags: ["frontend"],
    content: SampleMarkdown
  },
  {
    id: uuid.v1(),
    image: "spring.png",
    title: "An Introduction to MVC Pattern",
    date: "April 02",
    author: "blessedcrown",
    tags: ["backend"],
    content: SampleMarkdown
  },
  {
    id: uuid.v1(),
    image: "vuejs.png",
    title: "Creating a Schema-Based Form System",
    date: "March 12",
    author: "blessedcrown",
    tags: ["frontend"],
    content: SampleMarkdown
  },
];

onMounted(() => {
  store.$reset();
  initPost.forEach((post) => {
    store.addPost(post);
  });
});
</script>

<template>
  <content class="content">
    <div class="content-top">
      <div>
        <h1>Template blog made with vue.</h1>
        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Corporis itaque harum illum, ut reprehenderit, nesciunt quam fuga, voluptates nihil temporibus fugit expedita? Placeat optio iusto aperiam, aliquam eveniet consequatur reiciendis?</p>
      </div>
      <img class="header-image" src="@/assets/images/logo.svg" />
    </div>

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
  </content>
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
