<template>
  <Input :newAd="newAd"/>
  <Button @click="handleSubmit"/>
</template>

<script setup>
    import { ref } from 'vue';
    import api from '../api';

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
      console.log("New Ad: ", newAd.value);
      api.postAd(newAd.value)
          .then(Response => {
            adStore.addAd(Response.data);
            router.push('/allads');
          })
          .catch(error => {
            console.log("Došlo k chybě: ", error);
          })
    };

  </script>