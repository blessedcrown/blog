<script setup>
import { ref } from "vue";

const isWriting = ref(true);
const content = ref("");
</script>

<template>
  <div class="editor">
    <div class="editor__tabs">
      <button class="editor__tab" :class="{'active': isWriting}" @click="isWriting = true">Write</button>
      <button class="editor__tab" :class="{'active': !isWriting}" @click="isWriting = false">Preview</button>
    </div>

    <textarea
      v-if="isWriting"
      class="textarea"
      placeholder="Start writing in markdown format"
      v-model="content"
    ></textarea>
    <VueShowdown
      v-else
      class="preview"
      placeholder="preview"
      :markdown="content"
      flavor="github"
      :options="{ emoji: true }"
    />
  </div>
</template>

<style scoped>
.editor {
  display: flex;
  flex-direction: column;
  width: 100%;
}
.editor__tabs {
  display: flex;
  width: 100%;
}
.editor__tab {
  background-color: white;
  border: 1px solid var(--border-color);
  border-bottom: 0px;
  border-radius: 5px 5px 0px 0px;
  padding: 10px 20px;
  transition: all 0.1s ease;
}
.editor__tab:hover {
  cursor: pointer;
  background-color: var(--border-color);
}
.active {
  background-color: var(--border-color);
}
.textarea {
  border: 1px solid var(--border-color);
  border-radius: 2px;
  padding: 10px 16px;
  font-size: var(--p-font-size);
  font-family: var(--p-font-family);
  resize: none;
  height: 600px;
  width: 100%;
  overflow-y: scroll;
}
.textarea:focus {
  outline: none;
}
.preview {
  border: 1px solid var(--border-color);
  border-radius: 2px;
  width: 100%;
  height: 600px;
  overflow-y: scroll;
  padding: 10px 16px;
}
</style>
