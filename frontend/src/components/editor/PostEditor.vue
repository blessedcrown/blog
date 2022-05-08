<script setup>
import { ref } from 'vue';

const content = ref('');
</script>

<template>
    <div class="editor">
        <textarea class="textarea" placeholder="Content" v-model="content"></textarea>
        <VueShowdown
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
    justify-content: stretch;
    width: 100%;
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
  border-right: 2px solid var(--border-color);
  width: 100%;
}
.textarea:focus {
  outline: none;
}
.preview {
  background-color: var(--input-background);
  width: 100%;
  padding: 10px 16px;
}
</style>