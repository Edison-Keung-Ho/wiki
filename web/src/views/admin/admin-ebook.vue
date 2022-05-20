<template>
    <a-layout-content style="padding: 0 50px">
        <a-layout style="padding: 24px 0; background: #fff">
            <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">

                <a-table :columns="columns"
                         :row-key="record => record.id"
                         :pagination="pagination"
                         :loading="loading"
                         @change="handleTableChange"
                         :data-source="ebooks">


                    <template #cover="{ text:cover }">

                       <img v-if="cover" :src="cover" alt="avatar">


                    </template>

                    <template v-slot:action="{text,record}">
                        <a-space size="small">
                            <a-button type="primary">
                                编辑
                            </a-button>
                            <a-button type="danger">
                                删除
                            </a-button>
                        </a-space>
                    </template>

                </a-table>

            </a-layout-content>
        </a-layout>
    </a-layout-content>
</template>

<script lang="ts">
    import { defineComponent, onMounted, ref } from 'vue';
    import axios from 'axios';
    export default defineComponent({
        name: 'AdminEbook',
        setup() {
            const param = ref();
            param.value = {};
            const ebooks = ref();
            const pagination = ref({
                current: 1,
                pageSize: 2,
                total: 0
            });
            const loading = ref(false);

            const columns = [
                {
                    title: '封面',
                    dataIndex: 'cover',
                    slots: { customRender: 'cover' }
                },
                {
                    title: '名称',
                    dataIndex: 'name'
                },
                {
                    title: '分类',
                    slots: { customRender: 'category' }
                },
                {
                    title: '文档数',
                    dataIndex: 'docCount'
                },
                {
                    title: '阅读数',
                    dataIndex: 'viewCount'
                },
                {
                    title: '点赞数',
                    dataIndex: 'voteCount'
                },
                {
                    title: 'Action',
                    key: 'action',
                    slots: { customRender: 'action' }
                }
            ];
            /**
             * 数据查询
             **/
            const handleQuery = (params: any) => {
                loading.value = true;
                // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
                ebooks.value = [];
                axios.get("/ebook/list",{
                    params:{
                        page:pagination.value.current,
                        size:pagination.value.pageSize
                    }
                }).then((response) => {
                    loading.value = false;
                    const data = response.data;
                    if (data.success) {
                        ebooks.value = data.content.list;

                        // 重置分页按钮
                        pagination.value.current = params.page;
                        // pagination.value.total = data.content.total;
                    } else {
                        // message.error(data.message);
                    }
                });
            };
            /**
             * 表格点击页码时触发
             */
            const handleTableChange = (pagination: any) => {
                console.log("看看自带的分页参数都有啥：" + pagination);
                handleQuery({
                    page: pagination.current,
                    size: pagination.pageSize
                });
            };
            onMounted(() => {
                handleQuery({
                    page:pagination.value.current,
                    size:pagination.value.pageSize,
                });
            });

            return {
                param,
                ebooks,
                pagination,
                columns,
                loading,
                handleTableChange,
            }
        }
    });
</script>