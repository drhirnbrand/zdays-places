import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule} from "@angular/forms";
import { PixelConfigurationForm } from './pixel-form/pixel-configuration-form.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatCardModule, MatFormFieldModule, MatInputModule} from "@angular/material";
import {ColorPickerModule} from "ngx-color-picker";
import { ZPlacesCardComponent } from './z-places-card/z-places-card.component';


@NgModule({
  declarations: [
    PixelConfigurationForm,
    ZPlacesCardComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatFormFieldModule,
    MatCardModule,
    ColorPickerModule
  ],
  exports:[PixelConfigurationForm],
  providers: [],
  bootstrap: [ZPlacesCardComponent]
})
export class ZDaysPlacesModule { }
