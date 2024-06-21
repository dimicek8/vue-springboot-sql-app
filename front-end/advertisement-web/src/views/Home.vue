<template>
  <Input :newAd="newAd"/>
  <Button @click="handleSubmit"/>
</template>

<script setup>
    import { ref } from 'vue';

    import Button from '/src/components/Button.vue';
    import Input from '/src/components/Input.vue';

    import { useAdStore } from '../stores/adStore';
    import { useRouter } from 'vue-router';

    const router = useRouter();
    const adStore = useAdStore();

    const newAd = ref({
      firstName: "",
      lastName: "",
      email: "",
      city: "",
      price: "",
      currency: "",
      description: "",
      files :[]
    });

    const handleSubmit = () => {
      adStore.addAd({ ...newAd.value });
      router.push('/allads');
    }

  </script>