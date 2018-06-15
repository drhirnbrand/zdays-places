import {Component, Inject} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'pixel-configuration-form',
  templateUrl: './pixel-configuration-form.component.html',
  styleUrls: ['./pixel-configuration-form.component.css']
})
export class PixelConfigurationForm {

  pixelForm: FormGroup;

  constructor(@Inject(FormBuilder) formBuilder: FormBuilder) {
    this.pixelForm = formBuilder.group({
      top: [null, Validators.compose([Validators.min(0), Validators.required])],
      right: [null, Validators.compose([Validators.min(0), Validators.required])],
      color: [null, Validators.required]
    });
  };
}
