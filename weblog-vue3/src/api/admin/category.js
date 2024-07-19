import axios from "@/axios";

// 获取分类 select 数据
export function getCategorySelectList() {
    return axios.post("/admin/category/select/list")
}
// 获取分类分页数据
export function getCategoryPageList(data) {
    return axios.post("/admin/catagory/list", data)
}
export function addCategory(data) {
    return axios.post("/admin/catagory/add", data)
}

// 删除分类
export function deleteCategory(id) {
    return axios.post("/admin/category/delete", {id})
}