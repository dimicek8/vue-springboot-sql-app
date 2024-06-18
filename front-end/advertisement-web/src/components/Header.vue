<template>
    <header class="absolute inset-x-0 top-0 z-50">
            <nav class="flex items-center justify-between p-6 lg:px-8" aria-label="Global">
              <div class="flex lg:flex-1">
                <router-link to="/" class="-m-1.5 p-1.5">
                  <img class="h-20 w-auto" src="/logoPNG.png" alt="Logo" />
                </router-link>
              </div>
              <div class="flex lg:hidden">
                <button type="button" class="-m-2.5 inline-flex items-center justify-center rounded-md p-2.5 text-gray-700" @click="mobileMenuOpen = true">
                  <span class="sr-only">Open main menu</span>
                  <Bars3Icon class="h-6 w-6" aria-hidden="true" />
                </button>
              </div>
              <div class="hidden lg:flex lg:gap-x-12">
                <router-link v-for="item in navigation" :key="item.name" :to="item.href" class="text-sm font-semibold leading-6 text-cyan-900 hover:text-cyan-700">{{ item.name }}</router-link>
              </div>
              <div class="hidden lg:flex lg:flex-1 lg:justify-end">
              </div>
            </nav>
            <Dialog class="lg:hidden" @close="mobileMenuOpen = false" :open="mobileMenuOpen">
              <div class="fixed inset-0 z-50" />
              <DialogPanel class="fixed inset-y-0 right-0 z-50 w-full overflow-y-auto bg-white px-6 py-6 sm:max-w-sm sm:ring-1 sm:ring-gray-900/10">
                <div class="flex items-center justify-between">
                  <router-link to="/" class="-m-1.5 p-1.5">
                    <img class="h-8 w-auto" src="/logoPNG.png" alt="Inzerát logo"/>
                  </router-link>
                  <button type="button" class="-m-2.5 rounded-md p-2.5 text-gray-700" @click="mobileMenuOpen = false">
                    <span class="sr-only">Close menu</span>
                    <XMarkIcon class="h-6 w-6" aria-hidden="true" />
                  </button>
                </div>
                <div class="mt-6 flow-root">
                  <div class="-my-6 divide-y divide-gray-500/10">
                    <div class="space-y-2 py-6">
                      <router-link v-for="item in navigation" :key="item.name" :to="item.href" class="-mx-3 block rounded-lg px-3 py-2 text-base font-semibold leading-7 text-gray-900 hover:bg-gray-50" @click="mobileMenuOpen = false">{{ item.name }}</router-link>
                    </div>
                    <div class="py-6">
                    </div>
                  </div>
                </div>
              </DialogPanel>
            </Dialog>
    </header>

</template>

<script setup>

  const navigation = [
    { name: 'Domů', href: '/' },
    { name: 'Všechny inzeráty', href: '/allads' },
    { name: 'O nás', href: '/about' },
    { name: 'Kontakt', href: '/contact' },
  ]

    import { ref } from 'vue'
    import { Dialog, DialogPanel } from '@headlessui/vue'
    import { Bars3Icon, XMarkIcon } from '@heroicons/vue/24/outline'
  
  const mobileMenuOpen = ref(false)
</script>