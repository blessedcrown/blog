<script setup>
import { computed } from '@vue/runtime-core'

const props = defineProps({
  'type': String
})

const title = computed(() => {
  return props.type;
})
</script>

<template>
  <div class="category-card">
    <h4>{{title}}</h4>
  </div>
</template>
    
<style scope>
.category-card {
  padding: 20px;
  border-radius: 10px;
  background-color: var(--background-soft);
}
</style>