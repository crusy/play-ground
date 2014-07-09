
/*
 * Update tasks:
 */

$('input[type=checkbox].submit-task').change(function(e) {
	$(this).closest('form').submit();
});

$('button.submit-task').click(function(e) {
	$(this).closest('form').submit();
});

$('div.submit-task a').click(function(e) {
	e.preventDefault();
	var f = $(this).closest('form');
	$('<input>').attr({
		type : 'hidden',
		name : 'listId',
		value : $(this).data('listid')
	}).appendTo(f);
	f.submit();
});

/*
 * Delete tasks:
 */

$('button.delete-task').click(function(e) {
	var f = $(this).closest('form');
	$('<input>').attr({
		type : 'hidden',
		name : 'id',
		value : $(this).data('taskid')
	}).appendTo(f);
	f.submit();
});

/*
 * Add task:
 */

$('div.add-task a').click(function(e) {
	e.preventDefault();
	$('#listSelector span.text').html($(this).html());
	$('#listSelector').data("listid", $(this).data('listid'));
});

$('button.add-task').click(function(e) {
	var f = $(this).closest('form');
	$('<input>').attr({
		type : 'hidden',
		name : 'listId',
		value : $('#listSelector').data("listid")
	}).appendTo(f);
	f.submit();
});

/*
 * Update list:
 */

$('button.submit-list').click(function(e) {
	$(this).closest('form').submit();
});

/*
 * Delete list:
 */

$('button.delete-list').click(function(e) {
	var f = $(this).closest('form');
	$('<input>').attr({
		type : 'hidden',
		name : 'id',
		value : $(this).data('listid')
	}).appendTo(f);
	f.submit();
});

/*
 * Add list:
 */

$('button.add-list').click(function(e) {
	$(this).closest('form').submit();
});