<script setup>
import { ref } from "vue";
import CategoryCard from "@/components/card/CategoryCard.vue";
import PostCard from "@/components/card/PostCard.vue";

const posts = ref([
  {
    id: Math.random(),
    image: "node.png",
    title: "Front End Tables: Sorting, Filtering, and Pagination",
    date: "May 02",
  },
  {
    id: Math.random(),
    image: "spring.png",
    title: "An Introduction to MVC Pattern",
    date: "April 02",
  },
  {
    id: Math.random(),
    image: "vuejs.png",
    title: "Creating a Schema-Based Form System",
    date: "March 12",
  },
]);
</script>

<template>
  <content class="content">
    <h4>Dashboard</h4>
    <div class="category-container">
      <CategoryCard class="card" type="post"></CategoryCard>
      <CategoryCard class="card" type="category"></CategoryCard>
      <CategoryCard class="card" type="users"></CategoryCard>
    </div>
    <h4>Latest Posts</h4>
    <div class="post-container">
      <PostCard v-for="post in posts" 
        :key="post.id" 
        :image="post.image"
        :title="post.title"
        :date="post.date"
        class="post-card" />
    </div>
  </content>
</template>

<style scope>
.content {
}
.category-container {
  display: flex;
  width: max-content;
  margin-bottom: 50px;
}
.card {
  margin-right: 40px;
}
.post-card {
  margin-bottom: 15px;
}
</style>
