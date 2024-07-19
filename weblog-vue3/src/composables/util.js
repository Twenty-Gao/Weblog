// 消息提示
export function showMessage(message = '用户名或密码错误', type = 'success', customClass = '') {
    return ElMessage({
        type: type,
        message,
        customClass,
    })
}
import nprogress from "nprogress"
// 显示页面加载 Loading
export function showPageLoading() {
    nprogress.start()
}

// 隐藏页面加载 Loading
export function hidePageLoading() {
    nprogress.done()
}
// 弹出确认框
export function showModel(content = '提示内容', type = 'warning', title = '') {
    return ElMessageBox.confirm(
        content,
        title,
        {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type,
        }
    )
}