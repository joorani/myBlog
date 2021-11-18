
$(document).ready(function () {
    showList();
})
// window.onload = function() {
//     if(!window.location.hash) {
//         window.location = window.location + '#loaded';
//         window.location.reload();
//     }
// }

function showList() {
    $('#list-group').empty();
    $.ajax({
        type: 'GET',
        url: '/api/memos',
        success: function (response) {
            for (let i = 0; i < response.length; i++) {
                let posts = response[i];
                let tempList = addPostsList(posts);
                $('#list-group').append(tempList);
            }
        }
    })
}

function addPostsList(posts) {
    return `<li class="item" onclick="moveDetail(${posts.id})">
            <div class="list-group-item list-group-item-action" id="${posts.id}">
                    <h5 class="mb-1">${posts.title}</h5>
                <p class="mb-1">${posts.author}</p>
                <small class="text-muted">${posts.createdAt}</small>
            </div>
        </li>`;
}

function moveDetail(id) {
    window.location.href = `detail.html?id=${id}` ;
}
