<script setup>
import { format } from "date-fns";
import { reactive, ref } from "vue";
import BaseButton from "@/components/button/BaseButton.vue";
import PostModal from "@/components/modal/PostModal.vue";
import PostEditor from "@/components/editor/PostEditor.vue";
import TextField from "@/components/input/TextField.vue";
import { usePostStore } from "@/stores/post";

const store = usePostStore();

const isModalOpen = ref(false);
const post = reactive({
  id: -1,
  image: "",
  title: "",
  date: "",
  author: "",
  tags: [],
  content: "",
});
const onSave = () => {
  //   post.date = format(new Date(), 'yyyy/MM/dd');
  //   // TODO: Get user context from pinia store
  //   post.author = "blessedcrown";
  //   store.addPost(post);

  isModalOpen.value = true;
};

const toggleModal = () => {
  isModalOpen.value = !isModalOpen.value;
};
</script>

<template>
  <section class="section">
    <PostModal
      v-if="isModalOpen"
      :post="post"
      @closeModal="toggleModal"
    ></PostModal>
    <h1>New Post</h1>
    <div class="section-container">
      <TextField class="input-text" placeholder="Title" v-model="post.title"></TextField>
      <PostEditor></PostEditor>
    </div>
    <div class="button-container">
      <BaseButton color="primary" @click="onSave">Save</BaseButton>
    </div>
  </section>
</template>

<style scoped>
.section-container {
  display: flex;
  flex-direction: column;
  margin-bottom: 30px;
}
.input-label {
  font-size: var(--h5-font-size);
  font-weight: var(--h-font-weight);
}
.input-text {
  margin-bottom: 20px;
}
.textarea {
  background-color: var(--input-background);
  border: 0px;
  border-radius: 2px;
  padding: 10px 16px;
  font-size: var(--p-font-size);
  font-family: var(--p-font-family);
  resize: none;
  height: 600px;
}
.textarea:focus {
  outline: none;
}
.button-container {
  display: flex;
  justify-content: space-between;
}
</style>
