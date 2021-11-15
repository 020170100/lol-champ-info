<template>
    <div class="modal-wrapper">
        <div class="modal">
            <h2>{{detailInfo.name}}</h2>
            <div>
                <img :src="detailInfo.big_image_url" alt="big image"><br>
                <span>Healh: {{detailInfo.hp}}</span><br>
                <span>Mana: {{detailInfo.mp}}</span><br>
                <span>Armor: {{detailInfo.armor}}</span><br>                
                <span>Magic Resistance: {{detailInfo.spellblock}}</span><br>
                <span>AD: {{detailInfo.attackdamage}}</span>
            </div>
            <button @click="$emit('close-modal')">Close</button>
        </div>
    </div>
    
    
</template>

<script>
export default ({
    name: 'DetailModal',
    props: ['detailInfo'],  
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

    img {
        height: 35%;
        width: 35%;
    }
</style>
