$(".dropdown-menu li a").click(function(){
  var selText = $(this).text();
  $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+' <span class="caret"></span>');
});

$(document).ready(function() {
    var max_fields      = 5; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID
    
    var x = 1; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append('<div><input type="text" name="telefone[]"/><a href="#" class="remove_field"> - </a></div>'); //add input box
        }
    });
    
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
});

//$(document).ready(function() {
//    // The maximum number of options
//    var MAX_OPTIONS = 5;
//
//    $('#surveyForm')
//        .formValidation({
//            framework: 'bootstrap',
//            icon: {
//                valid: 'glyphicon glyphicon-ok',
//                invalid: 'glyphicon glyphicon-remove',
//                validating: 'glyphicon glyphicon-refresh'
//            },
//            fields: {
//                question: {
//                    validators: {
//                        notEmpty: {
//                            message: 'The question required and cannot be empty'
//                        }
//                    }
//                },
//                'option[]': {
//                    validators: {
//                        notEmpty: {
//                            message: 'The option required and cannot be empty'
//                        },
//                        stringLength: {
//                            max: 100,
//                            message: 'The option must be less than 100 characters long'
//                        }
//                    }
//                }
//            }
//        })
//
//        // Add button click handler
//        .on('click', '.addButton', function() {
//            var $template = $('#optionTemplate'),
//                $clone    = $template
//                                .clone()
//                                .removeClass('hide')
//                                .removeAttr('id')
//                                .insertBefore($template),
//                $option   = $clone.find('[name="option[]"]');
//
//            // Add new field
//            $('#surveyForm').formValidation('addField', $option);
//        })
//
//        // Remove button click handler
//        .on('click', '.removeButton', function() {
//            var $row    = $(this).parents('.form-group'),
//                $option = $row.find('[name="option[]"]');
//
//            // Remove element containing the option
//            $row.remove();
//
//            // Remove field
//            $('#surveyForm').formValidation('removeField', $option);
//        })
//
//        // Called after adding new field
//        .on('added.field.fv', function(e, data) {
//            // data.field   --> The field name
//            // data.element --> The new field element
//            // data.options --> The new field options
//
//            if (data.field === 'option[]') {
//                if ($('#surveyForm').find(':visible[name="option[]"]').length >= MAX_OPTIONS) {
//                    $('#surveyForm').find('.addButton').attr('disabled', 'disabled');
//                }
//            }
//        })
//
//        // Called after removing the field
//        .on('removed.field.fv', function(e, data) {
//           if (data.field === 'option[]') {
//                if ($('#surveyForm').find(':visible[name="option[]"]').length < MAX_OPTIONS) {
//                    $('#surveyForm').find('.addButton').removeAttr('disabled');
//                }
//            }
//        });
//});
