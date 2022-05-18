<script setup>
import { ref, watch } from "vue";
import PostListItem from "@/components/list/PostListItem.vue";
import TextField from "@/components/input/TextField.vue";
import { storeToRefs } from "pinia";
import { usePostStore } from "@/stores/post";

const store = usePostStore();
const { posts } = storeToRefs(store);
const filterWord = ref("");

const filteredPosts = ref([]);
filteredPosts.value = [...posts.value];

watch(filterWord, () => {
  filteredPosts.value = posts.value.filter((post) =>
    post.title.toLowerCase().includes(filterWord.value.toLowerCase())
  );
});
</script>

<template>
  <section class="section-top">
    <h1>Articles</h1>
    <p class="description">Search up all the dev related post here!</p>
    <TextField v-model="filterWord" placeholder="Search Post"></TextField>
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
.section-top {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 40px;
}
.tag-name {
  border-bottom: 3px solid var(--background-mute);
}
.description {
  font-size: var(--h5-font-size);
  color: rgb(100, 100, 100);
}
.post-list {
  display: flex;
  flex-direction: column;
}
</style>
