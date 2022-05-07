<script setup>
defineProps({
  modelValue: String,
  placeholder: String,
});
defineEmits(["update:modelValue"]);
</script>

<template>
  <input
    :value="modelValue"
    @input="$emit('update:modelValue', $event.target.value)"
    type="text"
    class="input"
    :placeholder="placeholder"
  />
</template>

<style scoped>
.input {
  width: 100%;
  padding: 0.75rem 1rem;
  border: 1px solid var(--border-color);
  border-radius: 8px;
}
</style>
