<script setup>
import { ref } from "vue";
import { useRoute } from "vue-router";
import { storeToRefs } from "pinia";
import { usePostStore } from "@/stores/post";
import PostListItem from "@/components/list/PostListItem.vue";

const route = useRoute();
const tagName = route.params.tag;

const store = usePostStore();
const { posts } = storeToRefs(store);

const filteredPosts = ref([]);
filteredPosts.value = posts.value.filter((post) =>
  post.tags.some((tag) => tag.toLowerCase() === tagName.toLowerCase())
);
</script>

<template>
  <section class="content-top">
    <h1>
      Posts tagged: <span class="tag-name">{{ tagName }}</span>
    </h1>
    <p class="description"><span class="post-count">{{filteredPosts.length}}</span> posts found</p>
  </section>

  <section class="post-list">
    <PostListItem
      v-for="post in filteredPosts"
      :link="post.id"
      :title="post.title"
      :date="post.date"
    ></PostListItem>
  </section>
</template>

<style scoped>
.content-top {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.tag-name {
  border-bottom: 3px solid var(--primary-color);
}
.description {
  font-size: var(--h5-font-size);
  color: rgb(100, 100, 100);
}
.post-count {
  color: black;
}
</style>
