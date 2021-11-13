<template>
    <div class="modal-wrapper">
        <div class="modal">
            <h2>{{champId}}</h2>
            <div>
                Image, Stats,...
            </div>
            <button @click="$emit('close-modal')">Go back</button>
        </div>
    </div>
    
    
</template>

<script>
export default ({
    name: 'DetailModal',
    props: ['champId'],
    
    methods: {
        setChampInfo(){
            
        }
    },
})
</script>

<style scoped>
    .modal-wrapper {
        position: fixed;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        display: flex;
        justify-content: center;
        background-color: rgba(105, 105, 105, 0.521);
    }

    .modal {
        background-color: white;
        text-align: center;
        height: 500px;
        width: 500px;
        margin-top: 10%;
        padding: 60px 0;
        border-radius: 20px;
    }
</style>
