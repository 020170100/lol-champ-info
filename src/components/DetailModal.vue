<template>
    <div class="modal-wrapper">
        <div class="modal">
            <h2>{{detailInfo.name}}</h2>
            <div class="data-wrapper">
                <img :src="detailInfo.big_img_url" alt="big image">
                <div class="data-table">
                    <table>
                        <tbody>
                            <tr>
                                <td>
                                    <label for="health">Health:</label>
                                </td>
                                <td>
                                    <input id="health" type="number" :value="detailInfo.health" :disabled = editable>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="mana">Mana:</label>
                                </td>
                                <td>
                                    <input id="mana" type="number" :value="detailInfo.mana" :disabled = editable>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="armor">Armor:</label>
                                </td>
                                <td>
                                    <input id="armor" type="number" :value="detailInfo.armor" :disabled = editable><br>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="attackdamage">Attack Damage:</label>
                                </td>
                                <td>
                                    <input id="attackdamage" type="number" :value="detailInfo.attackdamage" :disabled = editable><br>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div v-show="showNormalBtns" class="btn-row">
                <button @click="$emit('close-modal')">Close</button>
                <button @click="clickedEdit">Edit</button>
                <button @click="clickedDelete(detailInfo.id), $emit('close-modal')">Delete</button>
            </div>
            <div v-show="showEditBtns" class="btn-row">
                <button @click="cancelEdit">Cancel</button>
                <button @click="save">Save</button>
            </div>
        </div>
    </div>
    
    
</template>

<script>


export default ({
    name: 'DetailModal',
    props: ['detailInfo'],

    data:function(){
        return{
            editable : true,
            showEditBtns : false,
            showNormalBtns : true
        }
    },

    methods:{

        clickedEdit(){
            this.editable = false
            this.showNormalBtns = false
            this.showEditBtns = true

        },

        cancelEdit(){
            this.editable = true
            this.showNormalBtns = true
            this.showEditBtns = false
        },

        save(){
            

            this.cancelEdit()
        },
        async clickedDelete(id){
          let response = await fetch("http://localhost:8080/champ/" + id, {
            method: 'DELETE',
            headers: {
              'Content-type': 'application/json'
            }
          });
          console.log(response)

        }


    }
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
        height: 600px;
        width: 500px;
        margin-top: 10%;
        padding-top: 10px;
        border-radius: 20px;
    }

    img {
        height: 35%;
        width: 35%;
    }

    .data-table table{
        margin: auto;
    }
</style>
