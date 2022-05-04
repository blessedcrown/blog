<script setup>
import { onMounted } from "vue";
import { uuid } from "vue-uuid";
import { storeToRefs } from "pinia";
import { usePostStore } from "@/stores/post";
import CategoryCard from "@/components/card/CategoryCard.vue";
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
  },
  {
    id: uuid.v1(),
    image: "spring.png",
    title: "An Introduction to MVC Pattern",
    date: "April 02",
    author: "blessedcrown",
    tags: ["backend"],
  },
  {
    id: uuid.v1(),
    image: "vuejs.png",
    title: "Creating a Schema-Based Form System",
    date: "March 12",
    author: "blessedcrown",
    tags: ["frontend"],
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
    <h4>Dashboard</h4>
    <div class="category-container">
      <CategoryCard class="category-card" type="post"></CategoryCard>
      <CategoryCard class="category-card" type="category"></CategoryCard>
      <CategoryCard class="category-card" type="users"></CategoryCard>
    </div>
    <h4>Latest Posts</h4>
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
    <h4>Highlights</h4>
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
